# Utilisation d'une image de base avec l'environnement .NET Core SDK pour la compilation
FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /app

# Copie des fichiers du projet et restauration des dépendances
COPY ChatService.csproj ./
RUN dotnet restore

# Copie de tout le code source et construction du projet
COPY . ./
RUN dotnet publish -c Release -o out

# Utilisation d'une image de base plus légère pour exécuter l'application
FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS runtime
WORKDIR /app

# Copie des fichiers publiés à partir de l'étape précédente
COPY --from=build /app/out ./

# Exécution de l'application
ENTRYPOINT ["dotnet", "ChatService.dll"]