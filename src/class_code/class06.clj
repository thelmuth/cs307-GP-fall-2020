(ns class-code.class06)

(comment
  To do:
  - Read C4B+T - Ch. 4 - up to (not including) Lazy Sequences
  - Homework 1 is on Piazza - due Sept. 9
  
  )

(defn how-big
  "Tells how big a number is"
  [num]
  (cond
    (< num 0) "That's negative"
    (< num 10) "single digit"
    (< num 100) "a bit bigger"
    :else (str "OMG " num " is so big!!!")))

; def - used to GLOBALLY assign a constnt value to a symbol
;       that will never change

(def nums (range 4 12))

; NEVER NEVER use def inside other code; just at the outermost level
; 
; It turns out, defn is just shorthand for (def name (fn ...))

(def cube
  (fn [x] ; an anonymous function
    (* x x x)))

(def todd {:name "Todd"
           :age 56})

(comment

  (how-big 5)
  (how-big 2999)

  nums
  (rest nums)
  nums

  (cube 5)

  ; you can define locally-scoped functions using anonymous functions

  (let [local-cube (fn [x] (* x x x))]
    (local-cube 12))

  (local-cube 12)

  (assoc todd :hair-color "black")
  (assoc todd :age 57)

  (get todd :age)
  (get todd :hair-color)
  (get todd :hair-color "pink")

  (:age todd)
  (todd :age)

  (keys todd)
  (vals todd)

  (sorted-map :name "Todd" :age 56)
  (sorted-map "todd" :person "2999" :number)

  (sort > '(8 3 8 1))

  (sort-by count '("hello" "hi" "2hjksadhjkahk"))

  nums

  (range 6)
  (range 0 100 5)

  (+ nums)
  (apply + 10000 1000000 nums)

  (str nums)
  (apply str nums)

  (max nums)
  (apply max nums)

  ;; map function applies a function to every element of a list

  (map cube nums)

  (map inc nums)

  (map str nums)
  
  (map (fn [x] (* x 5))
       nums)
  
  (map str
       nums
       '("a" "b" "c" "d")
       (range))
  
  (map (fn [x]
         [(* x 5) (str x)])
       nums)
  
  ;; special form of anonymous function
  (map #(* % 5)
       nums)
  
  (#(+ %1 %2) 100 5)
  
  (map count
       '("what" "is" "this"))
  
  
  )
  
  
  
  
  