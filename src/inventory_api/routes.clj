(ns inventory-api.routes
  (:require [compojure.core :as cc]
            [compojure.route :as route]
            [ring.util.response :refer [response status]]
            [inventory-api.db :as db]
            [clojure.core :refer :all]
            ))

;; Use When Using In-Memory Storage
(comment
  (def products (atom []))
  (def id-counter (atom 0))
(defn find-product [id]
  (some #(when (= (:id %) id) %) @products)
  )
)

(cc/defroutes product-routes

           (cc/GET "/products" []
             (response (db/get-all-products)))

           (cc/GET "/products/:id" [id]
             (if-let [product (db/get-product id)]
                     (response product)
                     (status (response {:error (str "Product with ID " id " not found")}) 404)))

           (cc/POST "/products" {body :body}
              (let [{:keys [name qty price]} body
                    id (str (random-uuid))
                    product {:_id id
                             :name name
                             :qty (int qty)
                             :price (double price)}]
                    (db/insert-product product)
                    (status (response product) 201)))

           (cc/PUT "/products/:id" [id :as {body :body}]
             (if-let [ _ (db/get-product id)]
               (let [updated (db/update-product id body)]
                 (response updated))
                 (status (response {:error (str "Product with ID " id " not found")}) 404)))

              (cc/DELETE "/products/:id" [id]
                (if-let [ _ (db/get-product id)]
                  (do
                    (db/delete-product id)
                    (response {:status (str "Product ID " id " deleted")}))
                  (status (response {:error (str "Product with ID " id " not found")}) 404)))

              (route/not-found (response {:error "Endpoint not found"}))

 )