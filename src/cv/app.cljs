(ns cv.app
  (:require [cv.button :refer [button]]
            [cv.state :refer [counter
                              increase-count!
                              decrease-count!
                              projects
                              consultants]]
            [cv.dropdown :refer [dropdown]]
            [cv.input :refer [input]]))

(defn app []
  [:div#main-div
    [:iframe#oskari-map {:src "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"}]])
