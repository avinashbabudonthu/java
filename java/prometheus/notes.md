# Setup Prometheus in Local
* docker run --name=prometheus -p 9090:9090 -v C:/projects/cyber-bully/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
* docker run -d --name=grafana -p 3000:3000 grafana/grafana

# Prometheus Queries
* http_server_requests_seconds_count
* system_cpu_usage
* http_server_requests_seconds_max
* http_server_requests_seconds_sum