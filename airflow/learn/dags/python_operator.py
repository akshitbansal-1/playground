from airflow import DAG
from airflow.operators.python import PythonOperator
from datetime import datetime, timedelta

default_args = {
    'owner': 'akshit',
    'retries': 2,
    'retry_delay': timedelta(minutes=2)
}

def greet():
    print('greet')
    return 'Akshit' # return name which will be used in the next task

def greetV2(age, ti):
    name = ti.xcom_pull(task_ids    ='Greet')
    print(f'Hi {name}, I am {age} years old')

with DAG(
    dag_id='python_opeator',
    description='Python operator DAG',
    start_date=datetime(2024, 4, 6),
    schedule_interval='@daily',
    default_args=default_args
) as dag:
    
    task1 = PythonOperator(
        task_id = 'Greet',
        python_callable=greet
    )

    task2 = PythonOperator(
        task_id = 'custom_greet',
        python_callable=greetV2,
        op_kwargs={ 'age': 25 }
    )


    task1 >> task2