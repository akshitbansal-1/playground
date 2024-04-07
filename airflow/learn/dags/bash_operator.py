from airflow import DAG
from airflow.operators.bash import BashOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'akshit',
    'retries': 2,
    'retry_delay': timedelta(minutes=2)
}

with DAG(
    dag_id='bash_opeator',
    description='Bash operator DAG',
    start_date=datetime(2024, 4, 6),
    schedule_interval='@daily',
    default_args=default_args
) as dag:
    task1 = BashOperator(
        task_id = 'task1',
        bash_command='echo Hello'
    )

    task2 = BashOperator(
        task_id = 'task2',
        bash_command='echo After first task'
    )

    task1 >> task2