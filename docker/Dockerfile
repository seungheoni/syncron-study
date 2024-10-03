# MySQL 이미지 사용
FROM mysql:latest

# 환경 변수 설정
ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes
ENV MYSQL_DATABASE=stock_example

# 초기화 스크립트를 복사
COPY ./init.sql /docker-entrypoint-initdb.d/

# 포트 노출
EXPOSE 3306