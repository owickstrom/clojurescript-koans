(ns clojurescript-koans.runner)

(defmacro fancy-assert
  "Assertion with fancy error messaging."
  ([x] (clojurescript-koans.runner/fancy-assert x ""))
  ([x message]
   `(try (assert ~x ~message)
         (catch js/Error e#
           (throw (js/Error. (str '~message "\n\n" '~x)))))))

(defmacro meditations [& forms]
  (let [topic (first forms)
        pairs (partition 2 (rest forms))
        tests (map (fn [[doc# code#]]
                     `(clojurescript-koans.runner/fancy-assert ~code# ~doc#))
                   pairs)]
    `(let [res# {:topic ~topic
                 :error (try (do ~@tests)
                             (catch js/Error e#
                               (.-message e#)))}]
       (clojurescript-koans.runner/update-result res#)
       (:error res#))))
