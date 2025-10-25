(defproject inventory-api "0.1.0-SNAPSHOT"
  :description "Inventory REST API with Routers in Clojure"
  :url "https://github.com/yourusername/inventory-api"
  :license {:name "Eclipse Public License - v 2.0" :url "https://www.eclipse.org/legal/epl-2.0"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-core "1.12.0"]
                 [ring/ring-jetty-adapter "1.12.0"]
                 [compojure "1.7.0"]
                 [cheshire "5.11.0"]
                 [ring/ring-json "0.5.1"]
                 [com.novemberain/monger "3.5.0"]
                 [ch.qos.logback/logback-classic "1.4.14"]]
  :main inventory-api.core)
