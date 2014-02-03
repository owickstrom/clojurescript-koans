(ns clojurescript-koans
  (:require [clojurescript-koans.blanks :refer [__ ___]]
            clojurescript-koans.runner)
  (:require-macros [clojurescript-koans.runner :refer [meditations]]))

(meditations
  "Group By"

  "To categorize a collection by some function, use group-by."
  (= __ (group-by count ["hello" "world" "foo" "bar"]))


  "You can simulate filter + remove in one pass"
  (= (get-odds-and-evens [1 2 3 4 5])
     ((partial (juxt filter remove) odd?) [1 2 3 4 5])
     [[1 3 5] [2 4]])

  "You can also group by a primary key"
  (= __
     (group-by :id [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"} ]))

  "But be careful when you group by non-required key"
  (= {"Bob" [{:name "Bob" :id 1}]
      "Mike" [{:name "Mike" :id 2}]
      __ [{:last-name "Smith" :id 1}]}
   (group-by :name [{:id 1 :name "Bob"}
                    {:id 2 :name "Mike"}
                    {:id 1 :last-name "Smith"}]))

  "The true power of group-by comes with custom functions"
  (= __
     (group-by #(if (:bad %) :naughty-list :nice-list)
               [{:name "Jimmy" :bad true}
                {:name "Jack" :bad false}
                {:name "Joe" :bad true}])))
