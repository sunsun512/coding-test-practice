SELECT sub.id AS CAR_ID
        , sub.type AS CAR_TYPE
        , CEIL(((sub.fee - (sub.fee * plan.discount_rate / 100)) * 30)) AS FEE
FROM (  # 대여 목록에서 기간이 11/1전에 만료라 가능한 차 + 대여 목록에 없는 차
        SELECT sub.id AS id, sub.type AS type, sub.fee AS fee
        FROM (  # 각 car_id의 가장 마지막 end_date를 기준으로 집계
                SELECT car.car_id AS id, car.car_type AS type, car.daily_fee AS fee
                    , history.car_id AS null_id, history.end_date AS date
                FROM car_rental_company_car AS car
                    LEFT JOIN car_rental_company_rental_history AS history ON history.car_id = car.car_id
                WHERE car.car_type IN ('세단', 'SUV')
                GROUP BY car.car_id
                ORDER BY car.car_id, history.end_date DESC
            ) sub
        WHERE DATE_FORMAT(sub.date, "%Y-%m-%d") < "2022-11-01" OR sub.null_id IS NULL
    ) sub
    LEFT JOIN car_rental_company_discount_plan AS plan ON sub.type = plan.car_type
WHERE plan.duration_type = '30일 이상'
    AND 500000 <= CEIL(((sub.fee - (sub.fee * plan.discount_rate / 100)) * 30))
    AND CEIL(((sub.fee - (sub.fee * plan.discount_rate / 100)) * 30)) < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC
