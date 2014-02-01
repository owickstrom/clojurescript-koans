(ns clojurescript-koans
  (:require [clojurescript-koans.blanks :refer [__ ___]]
            clojurescript-koans.runner)
  (:require-macros [clojurescript-koans.runner :refer [meditations]]))

(def atomic-clock (atom 0))

(meditations
  "Atoms"

  "In the beginning, there was number"
  (= __ (deref atomic-clock))

  "You can get the number more succinctly, but it's the same"
  (= __ @atomic-clock)

  "You can change at the swap meet"
  (= __ (do
          (swap! atomic-clock inc)
          @atomic-clock))

  "Keep taxes out of this: swapping requires no transaction"
  (= 5 (do
         __
         @atomic-clock))

  "Any number of arguments might happen during a swap"
  (= __ (do
          (swap! atomic-clock + 1 2 3 4 5)
          @atomic-clock))

  "Atomic atoms are atomic"
  (= __ (do
          (compare-and-set! atomic-clock 100 :fin)
          @atomic-clock))

  "When your expectations are aligned with reality, things proceed that way"
  (= :fin (do
            (compare-and-set! __ __ __)
            @atomic-clock)))
