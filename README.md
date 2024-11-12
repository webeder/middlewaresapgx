# Java SAP BTP Destination API

Este projeto utiliza o **SAP Business Technology Platform (SAP BTP)** para acessar destinos configurados via uma API REST em **Java** usando o **Spring Boot**. Ele oferece endpoints para acessar serviços SAP e middleware via controladores REST.

## Tecnologias Usadas
- **Spring Boot**: Framework para construção de APIs REST.
- **SAP Cloud SDK**: Para conectar-se a destinos configurados no SAP BTP.
- **Java**: Linguagem principal do projeto.

## Endpoints Principais

Este projeto expõe três endpoints principais, cada um acessando diferentes serviços ou funcionalidades do SAP BTP.

### 1. `/destination/` - Controlador de Destinos

Este endpoint é responsável por acessar e obter informações dos destinos configurados no SAP BTP.

```java
@RestController // Define a classe como um controlador REST
@RequestMapping("/destination") // Define a rota base para este controlador
public class DestinationController {
    // Métodos para acesso aos destinos são definidos aqui
}
Métodos Disponíveis
GET /destination: Retorna uma lista dos destinos configurados no SAP BTP.
POST /destination: Envia dados para um destino específico configurado.
2. /token - Controlador de Token
O endpoint /token é usado para gerenciar e acessar tokens de autenticação necessários para a comunicação com o SAP BTP.

@RestController // Define a classe como um controlador REST
@RequestMapping("/api/middleware") // Define a rota base para este controlador
public class MiddlewareController {
    // Métodos para acesso aos serviços de middleware são definidos aqui
}
Métodos Disponíveis
GET /api/middleware: Obtém informações do middleware configurado e dados necessários para comunicação com o SAP.
POST /api/middleware: Envia dados ao middleware usando o serviço SAP configurado como destino.
Como Usar
Configurar Destinos no SAP BTP:

Certifique-se de que os destinos estão configurados corretamente no SAP BTP.
Cada destino deve ter as permissões e configurações necessárias para ser acessado via API.
Executar o Projeto:

Clone o repositório:
