(ns clojurescript-koans.runner)

(defmacro safe-assert
  "Assertion with support for a message argument in all Clojure
  versions. (Pre-1.3.0, `assert` didn't accept a second argument and
  threw an error.)"
  ([x] `(clojurescript-kaons.macros/safe-assert ~x ""))
  ([x msg] `(assert ~x ~msg)))

(defmacro fancy-assert
  "Assertion with fancy error messaging."
  ([x] (clojurescript-koans.runner/fancy-assert x ""))
  ([x message]
   `(try (clojurescript-koans.runner/safe-assert ~x ~message)
         (catch js/Error e#
           (throw (js/Error. (str ~(when-let [line (:line (meta x))]
                                  (str "[LINE " line "] "))
                               '~message "\n" '~x)))))))
(defmacro meditations [& forms]
  (let [topic (first forms)
        pairs (partition 2 (rest forms))
        tests (map (fn [[doc# code#]]
                     `(clojurescript-koans.runner/fancy-assert ~code# ~doc#))
                   pairs)]
    `(try (do ~@tests)
          (catch js/Error e#
            (clojurescript-koans.runner/add-koan ~topic e#)
            (.error js/console (str e#))))))
