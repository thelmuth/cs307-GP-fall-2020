(ns class-code.class08)


(comment

  ;; Lazy sequences
  ;; Many functions (map, filter, range, etc.) are lazy
  ;; They only compute their elements when you need them

  (take 5 (filter even?
                  (range 10000000000)))

  ;; Infinite sequences: lazy sequences with no end

  ;(range) ; don't execute, this is infinite

  (take 5 (range))

  (nth (range) 10)

  (take 10 (map #(* % %)
                (range)))

  ; Find the first square number greater than 1000000
  (first (filter (fn [x] (< x 1000000))
                 (map #(* % %)
                      (range))))

  ; repeat - gives us an infinite sequence of one value
  (take 5 (repeat :hi))

  (repeat 5 :hi) ; the same thing

  ; repeatedly - call a function repeatedly and return
  ; an infinite sequence of the return values

  (rand)

  (take 5 (repeatedly rand))

  (take 5 (repeat (rand)))

  (rand-int 10)

  (take 5 (repeatedly #(rand-int 10)))

  (repeatedly 5 #(rand-int 10))

  (repeatedly 5 list)

  (take 5
        (map #(+ 100 %)
             (repeatedly rand)))

  ;iterate
  ; (iterate fn x)
  ; create an infinite sequence of:
  ; (x, (fn x), (fn (fn x)), (fn (fn (fn x))), ....)

  (take 10 (iterate inc 10))

  ; Powers of 2:

  (take 10 (iterate #(* % 2)
                    1))

  (nth (iterate #(*' % 2)
                1)
       100)

  ; We can assign a symbol to be associated with
  ; an infinite sequence

  (def infinite-foobar
    (iterate (fn [s] (str s "bar"))
             "foo"))

  (take 6 infinite-foobar)

  ; find the first with more than 40 characters
  (first (filter #(> (count %) 40)
                 infinite-foobar))

  ; Define an infinite fibonacci sequence
  ; 1 1 2 3 5 8 13
  ; a b
  ;   a b
  ; a = b
  ; b = a + b

  (defn next-fib
    [[a b]]
    [b (+' a b)])

  (next-fib [1 1])
  (next-fib [1 2])
  (next-fib [2 3])

  (def fib-sequence
    (map first
         (iterate next-fib [1 1])))

  (take 20 fib-sequence)

  (defn fast-fib
    "Returns the nth fibonacci number"
    [n]
    (nth fib-sequence
         n))

  (fast-fib 100)

  (defn our-plus
    ([] -1000)
    ([x] x)
    ([x y] (+ x y))
    ([x y & the-rest] (str x y the-rest)))
  
  (our-plus)
  (our-plus 5)
  (our-plus 6 7)
  (our-plus 1 2 3 4 5 6)
  
  
  ;; lazy-seq: a more general construction of lazy/infinite seqs

  (defn even-numbers
    ([] (even-numbers 0))
    ([n] (lazy-seq (cons n
                         (even-numbers (+ n 2))))))
  
  (take 10 (even-numbers))
  
  
  
  )