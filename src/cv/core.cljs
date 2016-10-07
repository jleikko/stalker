(ns cv.core
  (:require [reagent.core :as r]
            [cv.app :refer [app]]))

(r/render-component [app]
                          (. js/document (getElementById "app")))

(def channel (.connect js/OskariRPC
    (.getElementById js/document "oskari-map") 
    "http://www.paikkatietoikkuna.fi/published/fi/e8784853-1e4f-4644-9d00-5a3f2943f1e6"))

(.log channel "Channel present")

(.onReady channel #(.log channel "Map ready"))