(ns clojurescript-koans.runner
  (:require [dommy.core :as dommy])
  (:require-macros [dommy.macros :refer [node sel1]]))

(defn add-koan [topic error]
  (dommy/append!
    (sel1 :.koans)
    [:.koan {:class (if error "error" "success")}
     [:h2 topic]
     [:pre (str error)]]))

