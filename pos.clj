(defn index [coll]
  (cond
   (map? coll) (seq coll)
   (set? coll) (map vector coll coll)
   :else (map vector (iterate inc 0) coll)))

(index [:a 1 :b 2 :c 3 :d 4])
(index {:a 1 :b 2 :c 3 :d 4})
(index #{:a 1 :b 2 :c 3 :d 4})

(defn pos [pred coll]
  (for [[i v] (index coll) :when (pred v)] i))

(pos #{3 4} {:a 3 :b 2 :c 3 :d 4})
(pos even? [2 3 6 7])
(pos #{\x} "xiagx")
