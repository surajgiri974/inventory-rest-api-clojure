(ns inventory-api.routes
(:require [compojure.core :refer :all]
          [ring.util.response :refer [response status]]))

(def products (atom []))
(def id-counter (atom 0))

(defn find-product [id]
  (some #(when (= (:id %) id) %) @products)
  )

(defroutes product-routes
           (GET "/products" [] (response  @products))
           (GET "/products/:id" [id]
             (let [id (Integer/parseInt id)
                   product (find-product id)]
                   (if product
                     (response product)
                     (status (response {:error (str "Product with ID " id " not found")}) 404))))
           (POST "/products" {body :body}
              (let [{:keys [name qty price]} body
                    id (swap! id-counter inc)
                    product {:id id :name name :qty (int qty) :price (double price)}]
                    (swap! products conj product)
                    (status (response product) 201)))

           (PUT "/products/:id" {body :body params :params}
             (let [id (Integer/parseInt (:id params))
                   product (find-product id)]
               (if product
                 (let [updated (merge product body)]
                   (swap! products #(mapv (fn [p] (if (= (:id p) id) updated p)) %))
                   (response updated))
                 (status (response {:error (str "Product with ID " id " not found")}) 404))))

           (DELETE "/products/:id" [id]
             (let [id (Integer/parseInt id)
                   product (find-product id)]
               (if product
                 (do
                   (swap! products #(vec (remove (fn [p] (= (:id p) id)) %)))
                   (response {:status (str "Product ID " id " deleted")}))
                 (status (response {:error (str "Product with ID " id " not found")}) 404)))))