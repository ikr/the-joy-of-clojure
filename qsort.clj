(use 'clojure.test)

(let [{:keys [left right]} {:left [1], :right [2]}] right)

(defn- partition [pivot values memo]
  (let [smaller? #(< % pivot), [x & xs] values, {:keys [left right]} memo]
    (if x
      (if (smaller? x)
        (recur pivot xs {:left (conj left x), :right right})
        (recur pivot xs {:left left, :right (conj right x)}))
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
