(ns class-code.class15)

(def adding '(+ 5 3))

adding

(eval adding)

;; eval takes any form and evaluates it
;; Different types of forms evaluate differently
;; literals (ex: 5, "hi there") evaluate to
;;   themselves
;; lists evaluate to function calls
;; symbols are pieces of data

'hi-there

(def sym 'this-is-a-symbol)

sym
(type sym)
(eval sym)

(def this-is-a-symbol 52)

(eval sym)


;;; What does this have to do with GP?
;;; Let's imagine we define a Push instruction
;;; like the following (note: this is NOT
;;; how you should do it)

(def some-push-state
  {:integer '(5 3 100)
   :string '("hi")})

(defn int-adder
  [push-state]
  (let [top-int (first (:integer push-state))
        second-int (second (:integer push-state))
        new-int-stack (cons (+ top-int second-int)
                            (rest (rest (:integer push-state))))]
    (assoc push-state :integer new-int-stack)))

(int-adder some-push-state)

;; Now, let's try this in a "program"

(def worlds-worst-program '(int-adder))

;; Now, "run" the program
(let [the-first-instruction (first worlds-worst-program)]
  ;(the-first-instruction some-push-state) ;; bad!!!
  (type the-first-instruction)
  the-first-instruction
  (eval the-first-instruction)
  )

;; the good way!
(let [the-first-instruction (eval (first worlds-worst-program))]
  (the-first-instruction some-push-state))

(symbol int-adder)

(symbol :hi-there)
(name :hi-there)

(eval (eval int-adder))

(eval #(+ % 4))

