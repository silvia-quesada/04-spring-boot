 # Día 4 — Docker local-only para app Java/Spring

**Objetivo:** contenerizar una app Spring Boot y ejecutarla **solo en localhost** dentro de la **VM Debian 13** (sin servidores).

## Requisitos
- Docker y Docker Compose plugin instalados en la VM.
- Maven disponible (o usar la fase de build del Dockerfile multi-stage).

## Comandos rápidos
```bash
# 1) Build local del JAR (opcional; la imagen lo hace también)
mvn -q -DskipTests package

# 2) Construir imagen
docker build -t curso/spring-boot-demo:local .

# 3) Ejecutar con compose (binding 127.0.0.1)
docker compose up --build -d

# 4) Probar endpoint (dentro de la VM)
curl -s http://127.0.0.1:8080/api/hello

# 5) Verificar puertos solo en localhost
ss -tulpen | grep LISTEN | grep 8080 || true

# 6) Parada y limpieza
docker compose down
./scripts/docker_clean.sh
```

## Notas de seguridad
- No publicar puertos fuera de la VM (usar siempre `127.0.0.1:`).
- Evitar imágenes privadas/credenciales.
- Documentar `docker system prune` solo cuando sea seguro.

## Problemas comunes
- **Permisos de Docker**: ejecuta `newgrp docker` o relogin tras añadir al grupo.
- **Descargas Maven**: si no hay Internet, usa un repositorio maven local o pre-descarga dependencias.
