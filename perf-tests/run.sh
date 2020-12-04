#REPORT="reports/$(date +%s).raw"

vegeta attack -duration="$2" -rate="$1" --targets=targets.raw | vegeta report --type=text >>"reports/$(date +%s).raw"
