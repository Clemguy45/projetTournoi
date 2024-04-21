using ChatService.Entities;
using Microsoft.AspNetCore.Mvc;

namespace ChatService.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class MessageController : ControllerBase
    {
        private static List<Message> _messages = new List<Message>();

        public MessageController()
        {

        }

        [HttpGet]
        public async Task<ActionResult<List<Message>>> GetAllMessage()
        {
            return Ok(_messages);
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<Message>> GetMessageById(int id)
        {
            foreach (Message m in _messages)
            {
                if (id == m.Id)
                {
                    return Ok(m);
                }
            }
            return NotFound();
        }

        [HttpPost]
        public async Task<ActionResult<List<Message>>> CreatedMessage(Message message)
        {
            _messages.Add(message);
            return Ok(_messages);
        }

        [HttpPut]
        public async Task<ActionResult<Message>> UpdateMessage(Message message)
        {

            foreach (Message m in _messages)
            {
                if (m.Id == message.Id)
                {
                    m.Content = message.Content;
                    m.Sender = message.Sender;
                    m.Timestamp = message.Timestamp;
                    return Ok(m);
                }
            }
            return NotFound();
        }

        [HttpDelete("{id}")]
        public async Task<ActionResult> DeleteMessage(int id)
        {
            for (int i = 0; i < _messages.Count; i++)
            {
                var m = _messages[i];
                if (id == m.Id)
                {
                    _messages.RemoveAt(i);
                    return Ok();
                }
            }
            return NotFound();
        }

    }
}
