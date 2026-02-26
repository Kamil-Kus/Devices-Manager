package kamil.kus.devices.manager.device;


import jakarta.persistence.*;
import kamil.kus.devices.manager.controller.DeviceDto;
import lombok.*;

@Getter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Status status;

    public DeviceDto toDeviceDto() {
        return DeviceDto.builder()
                .name(this.name)
                .type(this.getType())
                .status(this.status)
                .build();
    }
}
