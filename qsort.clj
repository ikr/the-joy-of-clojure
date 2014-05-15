(use 'clojure.test)

(defn- partition [pivot values memo]
  (let [smaller? #(< % pivot), [x & xs] values, {:keys [left right]} memo]
    (if x
      (recur pivot xs
       {:left (if (smaller? x) (conj left x) left), :right (if (smaller? x) right (conj right x))})
      {:left left, :right right})))

(defn qsort [values]
  (let [
        [pivot & tail] values,
        {:keys [left right]} (partition pivot tail {:left [], :right []})
        ]
    (if (seq values)
      (concat (qsort left) [pivot] (qsort right))
      [])))

(testing "qsort"
  (is (= [] (qsort [])))
  (is (= [42] (qsort [42])))
  (is (= [0 1 2 3 5 8 8 9 9] (qsort [9 8 8 1 2 3 5 9 0]))))

;;--------------------------------------------------------------------------------------------------

(defn lazy-qsort [values] values)

(testing "lazy-qsort"
  (is (= [] (lazy-qsort [])))
  (is (= [42] (lazy-qsort [42])))
  (is (= [0 1 2 3 5 8 8 9 9] (lazy-qsort [9 8 8 1 2 3 5 9 0]))))
