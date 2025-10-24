(defproject inventory-api "0.1.0-SNAPSHOT"
  :description "Inventory REST API with Routers in Clojure"
  :url "https://github.com/yourusername/inventory-api"
  :license {:name "MIT License" :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.12.0"]
                 [ring/ring-jetty-adapter "1.12.0"]
                 [compojure "1.7.0"]
                 [cheshire "5.11.0"]
                 [ring/ring-json "0.5.1"]]
  :main inventory-api.core)
