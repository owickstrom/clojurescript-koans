(ns clojurescript-koans.macros)

(defmacro safe-assert
  "Assertion with support for a message argument in all Clojure
  versions. (Pre-1.3.0, `assert` didn't accept a second argument and
  threw an error.)"
  ([x] `(clojurescript-kaons.macros/safe-assert ~x ""))
  ([x msg] `(assert ~x ~msg)))

(defmacro fancy-assert
  "Assertion with fancy error messaging."
  ([x] (clojurescript-koans.macros/fancy-assert x ""))
  ([x message]
   `(try (clojurescript-koans.macros/safe-assert ~x ~message)
         (catch js/Error e#
           (throw (js/Error. (str ~(when-let [line (:line (meta x))]
                                  (str "[LINE " line "] "))
                               '~message "\n" '~x)))))))
(defmacro meditations [& forms]
  (let [topic (first forms)
        pairs (partition 2 (rest forms))
        tests (map (fn [[doc# code#]]
                     `(clojurescript-koans.macros/fancy-assert ~code# ~doc#))
                   pairs)]
    `(try (do ~@tests)
          (catch js/Error e#
            (.error js/console (str e#))))))
