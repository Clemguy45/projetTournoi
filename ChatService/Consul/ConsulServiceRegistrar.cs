using System.Net;
using BCI.Extensions.ServiceDiscovery.Consul;
using Consul;

namespace ChatService.Consul;

public class ConsulServiceRegistrar
{
    private readonly ConsulClient _consulClient;

    public async Task RegisterService(string consulHost, string consulPort)
    {
        var registration = new AgentServiceRegistration
        {
            ID = Guid.NewGuid().ToString(), // Unique ID for the service
            Name = "chatservice",
            Port = 5200,
            Address = Dns.GetHostName(),
            Check = new AgentServiceCheck()
            {
                HTTP = "http://" + Dns.GetHostName() + ":8080/health", // URL pour vérifier la santé du service
                Interval = TimeSpan.FromSeconds(10),    // Vérification de la santé toutes les 10 secondes
                Timeout = TimeSpan.FromSeconds(5),     // Délai d'attente de 5 secondes pour chaque vérification
            }
        };

        using (var client = new ConsulClient(opt => {
                   opt.Address = new Uri("http://"+consulHost+":"+consulPort);
               }))
        {
            var result = client.Agent.ServiceRegister(registration).GetAwaiter().GetResult();
            // Si l'enregistrement a réussi
            if (result.StatusCode == HttpStatusCode.OK)
            {
                Console.WriteLine($"Service Message is OK");
            }
            else
            {
                Console.WriteLine("Failed to register service.");
            }
        }            
    }
    
}