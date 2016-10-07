(ns cv.simulator
  (:require [cv.button :refer [button]]
            [cv.state :refer [counter
                              increase-count!
                              decrease-count!
                              projects
                              consultants]]
            [cv.dropdown :refer [dropdown]]
            [cv.input :refer [input]]))

(defn simulator []
  [:div "JESSE"])
