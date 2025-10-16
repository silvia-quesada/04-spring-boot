#!/usr/bin/env bash
set -euo pipefail
docker compose up --build -d
echo ">> Espera unos segundos y prueba: curl -s http://127.0.0.1:8080/api/hello"
