-- login to sysdba account. Execute following grant permission
GRANT EXECUTE ON DBMS_AQADM TO practice;
GRANT Aq_administrator_role TO practice;

-- create AQ
create or replace type order_ot as object(
    order_id number,
    customer_id number,
    order_total number,
    ordered date
);

create or replace type orders_list_tt as table of order_ot;

begin
    SYS.DBMS_AQADM.CREATE_QUEUE_TABLE(
        queue_table => 'order_queue_table',
        queue_payload_type => 'order_ot',
        multiple_consumers => TRUE
    );
    
    SYS.DBMS_AQADM.CREATE_QUEUE(
        queue_name => 'order_queue',
        queue_table => 'order_queue_table'
    );
    
    SYS.DBMS_AQADM.START_QUEUE('order_queue');
    
end;