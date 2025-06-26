# Apache Camel YAML DSL com MQTT WebSocket

Este projeto demonstra como configurar Apache Camel com YAML DSL para integrar endpoints REST com broker MQTT via WebSocket, incluindo o uso de headers customizados.

## Como usar

### 1. Iniciar o broker MQTT

```bash
# Iniciar o Mosquitto com WebSocket
docker compose up -d

# Verificar se está rodando
docker compose ps

# Ver logs do broker
docker compose logs -f mosquitto
```

### 2. Executar a aplicação Camel

```bash
mvn clean compile exec:java
```

### 3. Testar os endpoints

#### Endpoints disponíveis:

```bash
# Endpoint simples para testes
curl -X POST http://localhost:8080/test-simple \
  -H "Content-Type: application/json" \
  -d '{"message": "hello world"}'

# Endpoint MQTT básico
curl -X POST http://localhost:8080/test-mqtt \
  -H "Content-Type: application/json" \
  -d '{"message": "test mqtt websocket"}'

# Endpoint MQTT com headers customizados
curl -X POST http://localhost:8080/test-mqtt-custom-headers \
  -H "Content-Type: application/json" \
  -d '{"message": "test with custom headers"}'
```

### 4. Parar o broker MQTT

```bash
# Parar e remover containers
docker compose down

# Parar mantendo dados
docker compose stop
```

## Configuração

### Portas utilizadas:

- **MQTT TCP:** `tcp://localhost:1883`
- **MQTT WebSocket:** `ws://localhost:9001`
- **REST API:** `http://localhost:8080`

### Configurações principais:

- **REST:** Configurado via `application.properties`
- **MQTT:** Configurado para WebSocket
- **Headers customizados:** Implementados via beans YAML/Java

## Estrutura do projeto

```
├── docker-compose.yml          # Orquestração do Mosquitto
├── mosquitto.conf              # Configuração MQTT com WebSocket
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/camel/
│   │   │       └── App.java   # Aplicação principal
│   │   └── resources/
│   │       ├── application.properties  # Configurações centralizadas
│   │       └── routes/        # Pasta com definições de rotas YAML
│   │           ├── *.yaml     # Arquivos de rotas modulares
│   │           └── ...        # Cada arquivo contém rotas específicas
└── pom.xml                    # Dependências Maven
```
