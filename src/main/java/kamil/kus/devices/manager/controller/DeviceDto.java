package kamil.kus.devices.manager.controller;

import kamil.kus.devices.manager.device.Status;
import kamil.kus.devices.manager.device.Type;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String name;
    private Type type;
    private Status status;
}
