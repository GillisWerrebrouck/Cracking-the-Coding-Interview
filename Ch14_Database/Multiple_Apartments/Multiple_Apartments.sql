SELECT distinct Tenants.TenantID,  Tenants.TenantName
FROM Tenants
JOIN AptTenants ON AptTenants.TenantID = Tenants.TenantID
GROUP BY Tenants.TenantID
HAVING count(*) > 1;