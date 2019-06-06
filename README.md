# Keycloak Event Listener for Kafka

This demo project listens for `Keycloak Events` and writes them to `Apache Kafka`.

## Prerequisite

- Docker (latest)
- Compose (latest)

## Quick Start

You can run the project with the following command

```bash
> docker-compose up -d
```

Check that all containers are up with:

```bash
> docker-compose ps
```

Tail the Keycloak logs and watch as events are printed to the console

```bash
> docker-compose logs -f keycloak
```

Now open the keycloak UI at [http://localhost:8080](http://localhost:8080/auth/realms/master/protocol/openid-connect/auth?client_id=security-admin-console&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fauth%2Fadmin%2Fmaster%2Fconsole%2F&state=929d4a33-e639-4ea4-a8c8-2ee34bf3d779&response_mode=fragment&response_type=code&scope=openid&nonce=d600bfc0-83a0-4bd2-8012-8db0a3140277)

login with:

username: juliuskrah  
password: password

Go to the `Events` left menu item, and navigate to `Config`. Under `Event Listeners`, add `keycloak-demo` and save.

Logout and log back in. Watch the console for changes.