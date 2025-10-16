#!/usr/bin/env bash
set -euo pipefail
docker compose down || true
# Limpieza selectiva
images=$(docker images -q curso/spring-boot-demo:local 2>/dev/null || true)
if [ -n "$images" ]; then docker rmi -f $images || true; fi
# Opcional: volúmenes/parada de huérfanos
docker volume prune -f || true
