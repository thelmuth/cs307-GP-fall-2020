(ns class-code.class07)

(def nums (range 4 12))

(def words '("only" "longest" "words" "will" "survive"))

(comment

  (filter even? nums)

  (filter #(> % 8)
          nums)

  (filter #(<= 5 (count %))
          words)

  ;; reduce - interposes function calls between elements of a list

  nums
  (reduce + nums)
  (apply + nums) ; same thing here, but not always

  ; (+ (+ (+ (+ 4 5) 6) 7) 8)

  (reduce + 100 nums)

  (reduce (fn [x y] (str x ", " y))
          nums)

  ; another way in Clojure
  (apply str (interpose ", " nums))


  (reduce list nums)

  ;;; Recursion

  (defn my-count
    [lst]
    (if (empty? lst)
      0
      (inc (my-count (rest lst)))))

  (my-count nums)
  (count nums)

  (my-count (range 100000))

  (defn fib
    "The nth Fibonacci number
     fib(0) = 1
     fib(1) = 1
     fib(n) = fib(n - 1) + fib(n - 2)"
    [n]
    (cond
      (<= n 0) 1
      (= n 1) 1
      :else (+ (fib (dec n))
               (fib (dec (dec n))))))
  
  (fib 5)
  
  (map fib (range 10))
  
  ;(fib 100)
  
  ; Tail recursion
  ; By using recur instead of a recursive call, and not doing anything besides
  ; returning the recusive result, Clojure doesn't have to track
  ; the recursive calls and can be more efficient
  ; NOTE: With recur, you can't do anything with the result of a recursive call
  
  (defn first-postive-in-list
    [numbers]
    (cond
      (empty? numbers) nil
      (< 0 (first numbers)) (first numbers)
      :else (recur (rest numbers))))
  
  (first-postive-in-list '(-3 -2 -6 4 -2 7 8))
  
  (first-postive-in-list (range -1000000 5))
  
  ; `loop` simply sets the recursion point for recur and declares
  ; parameters with their initial values
  
  (defn my-tail-count
    [in-lst]
    (loop [lst in-lst
           c 0]
      (if (empty? lst)
        c
        (recur (rest lst)
               (inc c)))))
  
  (my-tail-count nums)
  (my-tail-count (range 1000000))
  
  (defn my-tail-fib
    [n]
    (loop [n n
           x 1
           y 1]
      (if (<= n 0)
        x
        (recur (dec n)
               y
               (+' x y)))))
  
  (my-tail-fib 5)
  
  (map my-tail-fib (range 10))
  
  (my-tail-fib 100)
  
  (my-tail-fib 100000)
  
  ;; 1 1 2 3 5 8 13
  ;; x y
  ;;   x y
  ;;     x y
  ;;       x y
  
  )