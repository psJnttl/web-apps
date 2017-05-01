package fi.solita.ritari.dto;

public class EmployerDto {
    private final long id;
    private final String name;
    private final String yCode;
    
    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getyCode() {
        return yCode;
    }
    
    public static class Builder {
        private long id;
        private String name;
        private String yCode;
        
        public Builder id(long id) {
            this.id = id;
            return this;
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder yCode(String yCode) {
            this.yCode = yCode;
            return this;
        }
        public EmployerDto build() {
            return new EmployerDto(this);
        }
    }
    private EmployerDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.yCode = builder.yCode;
    }
}
