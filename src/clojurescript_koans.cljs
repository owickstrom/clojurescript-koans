(ns clojurescript-koans
  (:require [clojurescript-koans.blanks :refer [__ ___]]
            clojurescript-koans.runner)
  (:require-macros [clojurescript-koans.runner :refer [meditations]]))

(meditations "Equality"
  "We shall contemplate truth by testing reality, via equality"
  (= __ true)

  "To understand reality, we must compare our expectations against reality"
  (= __ (+ 1 1))

  "You can test equality of many things"
  (= (+ 3 4) 7 (+ 2 __))

  "Some things may appear different, but be the same"
  (= __ (= 2 2/1))

  "The loose equality of numbers is inherited from Javascript"
  (= true (= 2 2.0))

  "Something is not equal to nothing"
  (= __ (not (= 1 nil)))

  "Strings, and keywords, and symbols: oh my!"
  (= __ (= "foo" :foo 'foo))

  "Make a keyword with your keyboard"
  (= :foo (keyword __))

  "Symbolism is all around us"
  (= 'foo (symbol __))

  "When things cannot be equal, they must be different"
  (not= :fill-in-the-blank __))

(meditations "Lists"
  "Lists can be expressed by function or a quoted form"
  (= '(__ __ __ __ __) (list 1 2 3 4 5))

  "They are Clojure seqs (sequences), so they allow access to the first"
  (= __ (first '(1 2 3 4 5)))

  "As well as the rest"
  (= __ (rest '(1 2 3 4 5)))

  "Count your blessings"
  (= __ (count '(dracula dooku chocula)))

  "Before they are gone"
  (= __ (count '()))

  "The rest, when nothing is left, is empty"
  (= __ (rest '(100)))

  "Construction by adding an element to the front is easy"
  (= __ (cons :a '(:b :c :d :e)))

  "Conjoining an element to a list isn't hard either"
  (= __ (conj '(:a :b :c :d) :e))

  "You can use a list like a stack to get the first element"
  (= __ (peek '(:a :b :c :d :e)))

  "Or the others"
  (= __ (pop '(:a :b :c :d :e)))

  "But watch out if you try to pop nothing"
  (= __ (try
          (pop '())
          (catch js/Error e
            "No dice!")))

  "The rest of nothing isn't so strict"
  (= __ (try
          (rest '())
          (catch js/Error e
            "No dice!"))))

(meditations "Vectors"
  "You can use vectors in clojure as array-like structures"
  (= __ (count [42]))

  "You can create a vector from a list"
  (= __ (vec '(1)))

  "Or from some elements"
  (= __ (vector nil nil))

  "But you can populate it with any number of elements at once"
  (= [1 __] (vec '(1 2)))

  "Conjoining to a vector is different than to a list"
  (= __ (conj [111 222] 333))

  "You can get the first element of a vector like so"
  (= __ (first [:peanut :butter :and :jelly]))

  "And the last in a similar fashion"
  (= __ (last [:peanut :butter :and :jelly]))

  "Or any index if you wish"
  (= __ (nth [:peanut :butter :and :jelly] 3))

  "You can also slice a vector"
  (= __ (subvec [:peanut :butter :and :jelly] 1 3))

  "Equality with collections is in terms of values"
  (= (list 1 2 3) (vector 1 2 __)))

(meditations "Sets"
  "You can create a set by converting another collection"
  (= #{3} (set __))

  "Counting them is like counting other collections"
  (= __ (count #{1 2 3}))

  "Remember that a set is a *mathematical* set"
  (= __ (set '(1 1 2 2 3 3 4 4 5 5)))

  "You can ask clojure for the union of two sets"
  (= __ (clojure.set/union #{1 2 3 4} #{2 3 5}))

  "And also the intersection"
  (= __ (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

  "But don't forget about the difference"
  (= __ (clojure.set/difference #{1 2 3 4 5} #{2 3 5})))

(meditations "Maps"
  "Don't get lost when creating a map"
  (= {:a 1 :b 2} (hash-map :a 1 __ __))

  "A value must be supplied for each key"
  (= {:a 1} (hash-map :a __))

  "The size is the number of entries"
  (= __ (count {:a 1 :b 2}))

  "You can look up the value for a given key"
  (= __ (get {:a 1 :b 2} :b))

  "Maps can be used as functions to do lookups"
  (= __ ({:a 1 :b 2} :a))

  "And so can keywords"
  (= __ (:a {:a 1 :b 2}))

  "But map keys need not be keywords"
  (= __ ({2006 "Torino" 2010 "Vancouver" 2014 "Sochi"} 2010))

  "You may not be able to find an entry for a key"
  (= __ (get {:a 1 :b 2} :c))

  "But you can provide your own default"
  (= __ (get {:a 1 :b 2} :c :key-not-found))

  "You can find out if a key is present"
  (= __ (contains? {:a nil :b nil} :b))

  "Or if it is missing"
  (= __ (contains? {:a nil :b nil} :c))

  "Maps are immutable, but you can create a new and improved version"
  (= {1 "January" 2 __} (assoc {1 "January" } 2 "February"))

  "You can also create a new version with an entry removed"
  (= {__ __} (dissoc {1 "January" 2 "February"} 2))

  "Often you will need to get the keys, but the order is undependable"
  (= (list __ __ __)
     (sort (keys {2010 "Vancouver" 2014 "Sochi" 2006 "Torino"})))

  "You can get the values in a similar way"
  (= (list __ __ __)
     (sort (vals {2006 "Torino" 2010 "Vancouver" 2014 "Sochi"}))))

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

(meditations "Functions"
  "Calling a function is like giving it a hug with parentheses"
  (= __ (square 9))

  "Functions are usually defined before they are used"
  (= __ (multiply-by-ten 2))

  "But they can also be defined inline"
  (= __ ((fn [n] (* 5 n)) 2))

  "Or using an even shorter syntax"
  (= __ (#(* 15 %) 4))

  "Even anonymous functions may take multiple arguments"
  (= __ (#(+ %1 %2 %3) 4 5 6))

  "Arguments can also be skipped"
  (= __ (#(* 15 %2) 1 2))

  "One function can beget another"
  (= 9 (((fn [] ___)) 4 5))

  "Functions can also take other functions as input"
  (= 20 ((fn [f] (f 4 5))
           ___))

  "Higher-order functions take function arguments"
  (= 25 (___
          (fn [n] (* n n))))

  "But they are often better written using the names of functions"
  (= 25 (___ square)))

(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

(meditations "Conditionals"
  "You will face many decisions"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  "Some of them leave you no alternative"
  (= __ (if (> 4 3)
          []))

  "And in such a situation you may have nothing"
  (= __ (if (nil? 0)
          [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
              :doom
              __))

  "You may have a multitude of possible paths"
  (let [x 5]
    (= :your-road (cond (= x __) :road-not-taken
                        (= x __) :another-road-not-taken
                        :else __)))

  "Or your fate may be sealed"
  (= 'doom (if-not (zero? __)
          'doom
          'more-doom))

  "In case of emergency, sound the alarms"
  (= :sirens
     (explain-defcon-level __))

  "But admit it when you don't know what to do"
  (= __
     (explain-defcon-level :yo-mama)))

(meditations "Higher-order Functions"
  "The map function relates a sequence to another"
  (= [__ __ __] (map (fn [x] (* 4 x)) [1 2 3]))

  "You may create that mapping"
  (= [1 4 9 16 25] (map (fn [x] __) [1 2 3 4 5]))

  "Or use the names of existing functions"
  (= __ (map nil? [:a :b nil :c :d]))

  "A filter can be strong"
  (= __ (filter (fn [x] false) '(:anything :goes :here)))

  "Or very weak"
  (= __ (filter (fn [x] true) '(:anything :goes :here)))

  "Or somewhere in between"
  (= [10 20 30] (filter (fn [x] __) [10 20 30 40 50 60 70 80]))

  "Maps and filters may be combined"
  (= [10 20 30] (map (fn [x] __) (filter (fn [x] __) [1 2 3 4 5 6 7 8])))

  "Reducing can increase the result"
  (= __ (reduce (fn [a b] (* a b)) [1 2 3 4]))

  "You can start somewhere else"
  (= 2400 (reduce (fn [a b] (* a b)) __ [1 2 3 4]))

  "Numbers are not the only things one can reduce"
  (= "longest" (reduce (fn [a b]
                         (if (< __ __) b a))
                       ["which" "word" "is" "longest"])))

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (concat (list a) more)))
                   "!")))

(defmulti diet (fn [x] (:eater x)))
(defmethod diet :herbivore [a] __)
(defmethod diet :carnivore [a] __)
(defmethod diet :default [a] __)

(meditations "Runtime Polymorphism"
  "Some functions can be used in different ways - with no arguments"
  (= __ (hello))

  "With one argument"
  (= __ (hello "world"))

  "Or with many arguments"
  (= __
     (hello "Peter" "Paul" "Mary"))

  "Multimethods allow more complex dispatching"
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  "Animals have different names"
  (= "Thumper eats veggies."
    (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore}))

  "Different methods are used depending on the dispatch function result"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  "You may use a default method when no others match"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"})))

(meditations "Lazy Sequences"
  "There are many ways to generate a sequence"
  (= __ (range 1 5))

  "The range starts at the beginning by default"
  (= __ (range 5))

  "Only take what you need when the sequence is large"
  (= [0 1 2 3 4 5 6 7 8 9]
     (take __ (range 100)))

  "Or limit results by dropping what you don't need"
  (= [95 96 97 98 99]
     (drop __ (range 100)))

  "Iteration provides an infinite lazy sequence"
  (= __ (take 20 (iterate inc 0)))

  "Repetition is key"
  (= [:a :a :a :a :a :a :a :a :a :a ]
     (repeat 10 __))

  "Iteration can be used for repetition"
  (= (repeat 100 :foo)
     (take 100 (iterate ___ :foo))))

(meditations "Sequence Comprehensions"
  "Sequence comprehensions can bind each element in turn to a symbol"
  (= __
     (for [x (range 6)]
       x))

  "They can easily emulate mapping"
  (= '(0 1 4 9 16 25)
     (map (fn [x] (* x x))
          (range 6))
     (for [x (range 6)]
       __))

  "And also filtering"
  (= '(1 3 5 7 9)
     (filter odd? (range 10))
     (for [x __ :when (odd? x)]
       x))

  "Combinations of these transformations is trivial"
  (= '(1 9 25 49 81)
     (map (fn [x] (* x x))
          (filter odd? (range 10)))
     (for [x (range 10) :when __]
       __))

  "More complex transformations simply take multiple binding forms"
  (= [[:top :left] [:top :middle] [:top :right]
      [:middle :left] [:middle :middle] [:middle :right]
      [:bottom :left] [:bottom :middle] [:bottom :right]]
     (for [row [:top :middle :bottom]
           column [:left :middle :right]]
       __)))

(defn square [x] (* x x))

(meditations "Creating Functions"
  "One may know what they seek by knowing what they do not seek"
  (= [__ __ __] (let [not-a-symbol? (complement symbol?)]
                  (map not-a-symbol? [:a 'b "c"])))

  "Praise and 'complement' may help you separate the wheat from the chaff"
  (= [:wheat "wheat" 'wheat]
       (let [not-nil? ___]
         (filter not-nil? [nil :wheat nil "wheat" nil 'wheat nil])))

  "Partial functions allow procrastination"
  (= 20 (let [multiply-by-5 (partial * 5)]
          (___ __)))

  "Don't forget: first things first"
  (= [__ __ __ __]
       (let [ab-adder (partial concat [:a :b])]
         (ab-adder [__ __])))

  "Functions can join forces as one 'composed' function"
  (= 25 (let [inc-and-square (comp square inc)]
          (inc-and-square __)))

  "Have a go on a double dec-er"
  (= __ (let [double-dec (comp dec dec)]
          (double-dec 10)))

  "Be careful about the order in which you mix your functions"
  (= 99 (let [square-and-dec ___]
          (square-and-dec 10))))

(defn is-even? [n]
  (if (= n 0)
    __
    (___ (is-even? (dec n)))))

(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
      __
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  __)

(defn factorial [n]
  __)

(meditations "Recursion"
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003))

  "Reversing directions is easy when you have not gone far"
  (= '(1) (recursive-reverse [1]))

  "Yet it becomes more difficult the more steps you take"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 10000000000000 (factorial 1000))

  "But what happens when the machine limits you?"
  (< 10000000000000 (factorial 100003)))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

(meditations "Destructuring"
  "Destructuring is an arbiter: it breaks up arguments"
  (= __ ((fn [[a b]] (str b a))
         [:foo :bar]))

  "Whether in function definitions"
  (= (str "First comes love, "
          "then comes marriage, "
          "then comes Clojure with the baby carriage")
     ((fn [[a b c]] __)
      ["love" "marriage" "Clojure"]))

  "Or in let expressions"
  (= "Rich Hickey aka The Clojurer aka Go Time aka Macro Killah"
     (let [[first-name last-name & aliases]
           (list "Rich" "Hickey" "The Clojurer" "Go Time" "Macro Killah")]
       __))

  "You can regain the full argument if you like arguing"
  (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
     (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
       __))

  "Break up maps by key"
  (= "123 Test Lane, Testerville, TX"
     (let [{street-address :street-address, city :city, state :state} test-address]
       __))

  "Or more succinctly"
  (= "123 Test Lane, Testerville, TX"
     (let [{:keys [street-address __ __]} test-address]
       __))

  "All together now!"
  (= "Test Testerson, 123 Test Lane, Testerville, TX"
     (___ ["Test" "Testerson"] test-address)))

(def atomic-clock (atom 0))

(meditations "Atoms"
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

(defrecord Nobel [prize])
(deftype Pulitzer [prize])

(defprotocol Award
  (present [this recipient]))

(defrecord Oscar [category]
  Award
  (present [this recipient]
    (print (str "Congratulations on your "
                (:category this) " Oscar, "
                recipient
                "!"))))

(deftype Razzie [category]
  Award
  (present [this recipient]
    __))

(meditations "Datatypes"
  "Holding records is meaningful only when the record is worthy of you"
  (= __ (.prize (Nobel. "peace")))

  "Types are quite similar"
  (= __ (.prize (Pulitzer. "literature")))

  "Records may be treated like maps"
  (= __ (:prize (Nobel. "physics")))

  "While types may not"
  (= __ (:prize (Pulitzer. "poetry")))

  "Further study reveals why"
  (= __
     (map map? [(Nobel. "chemistry")
                (Pulitzer. "music")]))

  "Either sort of datatype can define methods in a protocol"
  (= __
     (with-out-str (present (Oscar. "Best Picture") "Evil Alien Conquerors")))

  "Surely we can implement our own by now"
  (= "You're really the Worst Picture, Final Destination 5... sorry."
     (with-out-str (present (Razzie. "Worst Picture") "Final Destination 5"))))

(meditations "JavaScript Interopability"
  "The dot signifies easy and direct JavaScript interoperation"
  (= __ (.toUpperCase "hello world"))

  "But instance method calls are very different from normal functions"
  (= ["HELLO" "WORLD"] (map ___ ["hello" "world"]))

  "Property functions are slashing prices!"
  (== __ (Math/pow 2 10))

  "Convert your ClojureScript greatness to Javascript"
  (== __ (= [1 2 3] #js [1 2 3]))

  "But it's only shallow"
  (== __ (= [1 2 3] (.-numbers #js {"numbers" [1 2 3]}))))

(meditations "Partition"
  "To split a collection you can use the partition function"
  (= '((0 1) (2 3)) (__ 2 (range 4)))

  "But watch out if there are not enough elements to form n sequences"
  (= '(__) (partition 3 [:a :b :c :d :e]))

  "You can use partition-all to also get partitions with less than n elements"
  (= __ (partition-all 3 (range 5)))

  "If you need to, you can start each sequence with an offset"
  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 __ (range 13)))

  "Consider padding the last sequence with some default values..."
  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [__] (range 7)))

  "... but notice that they will only pad up to the given sequence length"
  (= '((0 1 2) (3 4 5) __) (partition 3 3 [:these :are "my" "words"] (range 7))))

(defn get-odds-and-evens [coll]
  (let [{odds true evens false} (group-by __ coll)]
    [odds evens]))

(meditations "Group By"

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
