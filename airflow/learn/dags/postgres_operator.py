from airflow import DAG
from airflow.providers.postgres.operators.postgres import PostgresOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'akshit',
    'retries': 2,
    'retry_delay': timedelta(minutes=2)
}
with DAG(
    dag_id='postgres_opeator',
    description='Postgres operator DAG',
    start_date=datetime(2024, 4, 2),
    schedule_interval='@daily',
    default_args=default_args,
    catchup=True,
) as dag:
    

    task1 = PostgresOperator(
        task_id = 'select_1',
        postgres_conn_id='postgres_default',
        sql="""
            insert into test_table values(1);
        """
    )


    task1