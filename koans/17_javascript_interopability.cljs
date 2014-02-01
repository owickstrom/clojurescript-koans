(ns clojurescript-koans
  (:require [clojurescript-koans.blanks :refer [__ ___]]
            clojurescript-koans.runner)
  (:require-macros [clojurescript-koans.runner :refer [meditations]]))

(meditations
  "JavaScript Interopability"

  "You may have done more with JavaScript than you know"
  (= __ (type "warfare"))

  "The dot signifies easy and direct JavaScript interoperation"
  (= __ (.toUpperCase "hello world"))

  "But instance method calls are very different from normal functions"
  (= ["HELLO" "WORLD"] (map ___ ["hello" "world"]))

  "Property functions are slashing prices!"
  (== __ (Math/pow 2 10)))
