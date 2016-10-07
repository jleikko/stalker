(ns cv.app-test
  (:require [cljs.test :refer-macros [deftest testing is use-fixtures]]
            [cljs-react-test.utils :as tu]
            [cljs-react-test.simulate :as sim]
            [dommy.core :as dommy :refer-macros [sel1] :refer [text
                                                               value
                                                               attr] ]
            [reagent.core :as r]
            [cv.app :refer [app]]
            [cv.state :refer [app-state
                              init-app-state]]))

(def ^:dynamic c)

(use-fixtures :each (fn [test-fn]
                      (binding [c (tu/new-container!)]
                        (reset! app-state init-app-state)
                        (test-fn)
                        (tu/unmount! c))))

(deftest increase-test
  (testing "inc"
    (let [_ (r/render-component [app] c)
          node (sel1 c [:#inc])]
      (is (= 0 (:count @app-state)))
      (sim/click node nil)
      (is (= 1 (:count @app-state))))))

(deftest decrease-test
  (testing "dec"
    (let [_ (r/render-component [app] c)
          node (sel1 c [:#dec])]
      (is (= 0 (:count @app-state)))
      (sim/click node nil)
      (is (= -1 (:count @app-state))))))


(deftest title-test
  (testing "title found"
    (let [_ (r/render-component [app] c)
          node (sel1 c [:#main-title])]
      (is (= "Add new allocation" (text node))))))

(deftest projects-dropdown-test
  (let [_ (r/render-component [app] c)
        dropdown (sel1 c [:#projects-dropdown])]
    (testing "test-projects dropdown found"
      (is (not (nil? dropdown))))
    (testing "test if dropdown has at least 1 option"
      (is (not (nil? (sel1 dropdown :option)))))
    (testing "has text"
      (is (not (nil? (text (sel1 dropdown :option))))))
    (testing "has value"
      (is (not (nil? (attr (sel1 dropdown :option) :value)))))))

(deftest consultants-dropdown-test
  (let [_ (r/render-component [app] c)
        dropdown (sel1 c [:#consultants-dropdown])]
    (testing "test-consultants dropdown found"
      (is (not (nil? dropdown))))
    (testing "test if dropdown has at least 1 option"
      (is (not (nil? (sel1 dropdown :option)))))
    (testing "has text"
      (is (not (nil? (text (sel1 dropdown :option))))))
    (testing "has value"
      (is (not (nil? (attr (sel1 dropdown :option) :value)))))))

(deftest allocation-input-test
  (let [_ (r/render-component [app] c)
        allocation-input (sel1 c :#allocation-percentage)]
    (testing "testing input field exists"
      (is (not (nil? allocation-input))))
    (testing "testing text field default value exists"
      (is (= "number" (attr allocation-input :type))))))


