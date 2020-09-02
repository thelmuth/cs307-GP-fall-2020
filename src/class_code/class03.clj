(ns class-code.class03)

(comment

  ; strings: always double quoted, can go on multiple lines
  "hi there"

  "this string
   goes on multiple
   lines"

  (str "hello" "world")
  (str "hi" (+ 2 3))


  ; printing: multiple ways to print, println is
  ; the most common
  ; Note: returns nil

  (println "cat")
  (println "why" "do" "you" "have" 5 "cats")

  (prn "why" "do" 5)

  ; comments out the next form
  #_(prn (+ 2 3)
         (str "hi" "there"))

  (println 5 2 #_(+ 2 8))

  ; lists: look a lot like code
  '(1 2 3)
  '(+ 2 3)
  '(1 (+ 2 3) 4)

  (quote (1 2 3))

  (list 1 (+ 2 3) 4 + str)

  ; vectors: faster indexed access, slower in other ways
  [1 2 3]
  '[1 (+ 2 3) 3]

  (vector 1 2 3)

  '(5 :a "hi" ("a" "list"))

  (first '(:a :b :c :d :e))
  (rest '(:a :b :c :d :e))
  (last '(:a :b :c :d :e))
  (count '(:a :b :c :d :e))
  (nth '(:a :b :c :d :e) 3)

  (conj '(10 11 12) 4)
  (conj [10 11 12] 4)

  (concat '(1 2 3) '(4 5 6))
  (vec (concat [1 2 3] [4 5 6]))
  (concat '(1 2 3) [4 5 6] '(10 11) '(4 3 (7 2) 3))

  (flatten '(1 2 (3 (5) 3) (3 2)))

  (cons 4 '(1 2 3))
  
  ; let: allows you to assign values to symbols within
  ; a lexical context
  
  (let [nums '(1 2 3 4 5)
        the-first (first nums)]
    (+ the-first 100))
  
  ; note that no pure functions change values associated
  ; with symbols!
  (let [nums '(7 8 2 2 0)]
    (println nums)
    (println (conj nums 100))
    (println nums)
    #_(let [nums "this isn't a list of nums"]
      (println nums)) ;; this is very bad!
    (rest nums))
  
  ; defn
  ; define function
  (defn square
    "Squares the input x; this is a docstring"
    [x] ; this is the parameter
    (* x x))
  
  (square 5)
  (square 5.5)
  (square 2/3)
  (square "hi")
  
  (defn all-unique
    [things]
    (= (count things)
       (count (vec (set things)))))
  
  (all-unique [2 1 2 3 4])
  
  (vec (set [1 2 3 4]))
  
  (Math/sqrt 2)
  
  )


