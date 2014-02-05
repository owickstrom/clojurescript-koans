(ns clojurescript-koans.runner
  (:require [dommy.core :as dommy])
  (:require-macros [dommy.macros :refer [node sel1]]))

(def results (atom []))

(defn replace-by-topic [results result]
  (if (some #(= (:topic result) (:topic %)) results)
    (vec (map #(if (= (:topic result) (:topic %1))
                  result
                  %1)
              results))
    (conj results result)))

(defn update-result [result]
  (swap! results replace-by-topic result))

(defn clear-results []
  (dommy/set-html! (sel1 :.koans) ""))

(defn print-result [{:keys [topic error]}]
  (dommy/append!
    (sel1 :.koans)
    [:.koan {:class (if error "error" "success")}
     [:h2 topic]
     [:pre (str error)]]))

(defn print-results [results]
  (clear-results)
  (doseq [result results]
    (print-result result)))

(add-watch results :watch-change #(print-results %4))

