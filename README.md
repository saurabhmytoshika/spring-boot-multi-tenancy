## Spring Boot + Multi Tenency + Mysql + AuditorAware

# In entity we are using @createdby and @EntityListeners(AuditingEntityListener.class) and in mainclass using @EnableJpaAuditing annotation make it workable.

## To support multiple organization with single Database.

##  Organization_GUID column will automatically stored and retrieved.

# send value of organization in X-TenantID in header. check TenantFilter. 



