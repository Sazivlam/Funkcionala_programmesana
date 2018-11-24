(ns ld-6.ld-6)

(fn get-max [& args]  (last (sort args)))                   ;1.uzdevums

(fn palindrome? [s] (= (seq s) (reverse s)))                ;2.uzdevums