(ns cv.util)

(defn by-id [id]
  (. js/document (getElementById id)))
