(ns inventory-api.core
  (:require [compojure.core :refer [defroutes]]
            [compojure.route :as route]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [inventory-api.routes :refer [product-routes]])
  (:gen-class))

(def app
  (-> product-routes
      (wrap-json-body {:keywords? true})
      (wrap-json-response)))

(defn -main []
  (run-jetty app {:port 3000 :join? false})
  (println "Inventory Rest API running on http://localhost:3000")
  )


