(ns inventory-api.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [inventory-api.routes :refer [product-routes]])
  (:gen-class))

(def app
  (-> (routes product-routes (route/not-found {:error "Not Found"}))
      (wrap-json-response)
      (wrap-json-body {:keywords? true})
      (wrap-params)))

(defn -main []
  (jetty/run-jetty app {:port 3000 :join? false})
  (println "Inventory Rest API running on http://localhost:3000")
  )


