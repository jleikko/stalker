(ns cv.button)

(defn button [text id onclick]
   [:button {:on-click onclick :id id} text])
