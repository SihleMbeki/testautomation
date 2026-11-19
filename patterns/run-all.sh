#!/usr/bin/env bash
set -euo pipefail

patterns_dir="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"

for folder in "$patterns_dir"/[0-9][0-9]-*; do
  if [[ ! -d "$folder" ]]; then
    continue
  fi

  name="$(basename "$folder")"
  printf '\n========== %s ==========\n' "$name"
  (
    cd "$folder"
    mkdir -p out
    javac -d out *.java
    java -cp out Main
  )
done
