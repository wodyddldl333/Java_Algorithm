-- 코드를 작성해주세요
select year(a.DIFFERENTIATION_DATE) as `YEAR`, b.max_col - a.SIZE_OF_COLONY as `YEAR_DEV`, id
from ecoli_data a join (select left(DIFFERENTIATION_DATE, 4) as year, max(size_of_colony) as max_col
                        from ecoli_data
                        group by year) b
on left(a.DIFFERENTIATION_DATE, 4) = b.year
order by `YEAR`, `YEAR_DEV`;