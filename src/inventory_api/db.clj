(ns inventory-api.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]))

(defonce conn (mg/connect))
(defonce db (mg/get-db conn "inventory_db"))

(def collection "products")

(defn get-all-products []
  (mc/find-maps db collection))

(defn get-product [id]
  (mc/find-one-as-map db collection {:_id id}))

(defn insert-product [product]
  (mc/insert db collection product)
  )

(defn update-product [id updated-product]
  (mc/update db collection {:id id} {"$set" updated-product})
  )

(defn delete-product [id]
  (mc/remove db collection {:id id} )
  )

